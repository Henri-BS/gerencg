package com.altercode.gerencg.service;

import com.altercode.gerencg.dto.OrderCodeDTO;
import com.altercode.gerencg.dto.OrderStatsValuesDTO;
import com.altercode.gerencg.entity.OrderCode;
import com.altercode.gerencg.entity.OrderItem;
import com.altercode.gerencg.entity.OrderStats;
import com.altercode.gerencg.entity.Measure;
import com.altercode.gerencg.repository.*;
import com.altercode.gerencg.service.iservice.IOrderCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderCodeService implements IOrderCodeService {

    @Autowired
    private OrderCodeRepository codeRepository;

    @Autowired
    private OrderStatsRepository statsRepository;

    @Autowired
    private MeasureRepository measureRepository;


    @Override
    public Page<OrderCodeDTO> findItemsByCode(Pageable pageable, String code) {
        Page<OrderCode> result = codeRepository.findOrdersByCode(pageable, code);
        return result.map(x -> new OrderCodeDTO(x));
    }

    @Override
    public OrderCodeDTO findCodeById(String id) {
        OrderCode result = codeRepository.findById(id).get();
        return new OrderCodeDTO(result);
    }

    @Override
    public OrderCodeDTO saveOrder(OrderCodeDTO dto) {
        Measure packageType = measureRepository.findById(dto.getPackageType()).get();

        OrderCode add = new OrderCode();
        add.setCode(dto.getCode());
        add.setOrderDate(dto.getOrderDate());
        add.setDistributor(dto.getDistributor());
        add.setPackageType(packageType);

        return new OrderCodeDTO(codeRepository.saveAndFlush(add));
    }

    @Override
    public OrderCodeDTO updateOrder(OrderCodeDTO dto) {
        OrderCode edit = codeRepository.findById(dto.getCode()).get();
        Measure packageType = measureRepository.findById(dto.getPackageType()).get();

        edit.setCode(edit.getCode());
        edit.setOrderDate(dto.getOrderDate());
        edit.setDistributor(dto.getDistributor());
        edit.setPackageType(packageType);
        return new OrderCodeDTO(codeRepository.save(edit));
    }

    @Override
    public void deleteOrder(String id) {
        this.codeRepository.deleteById(id);
    }

    @Override
    public OrderCodeDTO orderTotalValues(OrderCodeDTO dto) {
        OrderCode code = codeRepository.findById(dto.getCode()).get();

        double sumValues = 0;
        int sumQuantity = 0;
        int sumPackages = 0;
        for (OrderItem i : code.getItems()) {
            sumValues = sumValues + i.getTotalValue();
            sumQuantity = sumQuantity + i.getItemQuantity();
            sumPackages = sumPackages + i.getPackageQuantity();
        }

        code.setTotalValue(sumValues);
        code.setTotalQuantity(sumQuantity);
        code.setTotalPackage(sumPackages);
        code.setAmountItems(code.getItems().size());
        codeRepository.save(code);

        return new OrderCodeDTO(code);
    }

    @Override
    public List<OrderCodeDTO> findOrdersByStats(OrderStats stats) {
        List<OrderCode> result = codeRepository.findOrdersByStats(stats);
        return result.stream().map(x -> new OrderCodeDTO(x)).collect(Collectors.toList());
    }


  /*  @Override
    public List<OrderStatsValuesDTO> statsValues(){
        return codeRepository.statsValues();
    }*/
}
