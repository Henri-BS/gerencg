import axios from 'axios';
import { useState, useEffect } from 'react';
import Chart from 'react-apexcharts'
import { CategoryStatsValue as CategoryStatsTotalValue } from 'types/category';
import { OrderPage, OrderStatsTotalValue } from 'types/order';
import { Props } from 'types/page';

import { BASE_URL } from 'utils/requests';


type ProportionChartData = {
    labels: string[];
    series: any[];
}

type SeriesData = {
    name: string;
    data: number[];
}

type QuantityChartData = {
    labels: {
        categories: string[];
    };
    series: SeriesData[];
}


export function OrderStatsCharts() {
    const [proportionChart, setChartData] = useState<ProportionChartData>({ labels: [], series: [] });

    useEffect(() => {
        axios.get(`${BASE_URL}/order-stats/sum-order-value`)
            .then((response) => {
                const data = response.data as OrderStatsTotalValue[];
                const myLabels = data.map(x => x.statsId);
                const mySeries = data.map(x => x.sumExpense);
                setChartData({ labels: myLabels, series: mySeries });
            });
    }, []);

    const [quantityChart, setQuantityChart] = useState<QuantityChartData>({
        labels: { categories: [] },
        series: [{ name: "", data: [] }]
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/order-stats/sum-order-quantity`)
            .then((response) => {
                const data = response.data as OrderStatsTotalValue[];
                const myLabels = data.map(x => x.statsId);
                const mySeries = data.map(x => x.amountOrders);
                setQuantityChart({
                    labels: { categories: myLabels },
                    series: [{ name: "Quantidade de Pedidos", data: mySeries }],

                });
            });
    }, []);

    const options = {
        legend: { show: true }
    }

    return (
        <div className="row ">
            <div className="chart-box col-lg-6">
                <div className="container-chart">
                    <h5 className="text-center">Custo Total de Pedidos por Mês</h5>
                    <Chart
                        options={{
                            ...options,
                            labels: proportionChart.labels,
                            theme: { mode: "dark" },
                            chart: { background: "#2a323a" }
                        }}
                        series={proportionChart.series}
                        type="pie"
                        height="300"
                    />
                </div>
            </div>
            <div className="chart-box col-lg-6">
                <div className="container-chart">
                    <h5 className="text-center">Quantidade de Pedidos por Mês</h5>
                    <Chart
                        options={{
                            ...options,
                            xaxis: quantityChart.labels,
                            theme: { mode: "dark" },
                            colors: ["#1a6"],
                            chart: { background: "#2a323a" },
                            grid: { borderColor: "#139acf" },
                        }}
                        labels={quantityChart.labels}
                        series={quantityChart.series}
                        type="bar"
                        height="300"
                    />
                </div>
            </div>
        </div>
    );
}

export function OrderStatsChartsByPediod({ id: statsId }: Props) {
    const [proportionChart, setProportionChart] = useState<ProportionChartData>({ labels: [], series: [] });

    useEffect(() => {
        axios.get(`${BASE_URL}/order/find-by-stats/${statsId}?size=10&sort=expense,desc`)
            .then((response) => {
                const data = response.data as OrderPage;
                const myLabels = data.content?.map(x => x.code);
                const mySeries = data.content?.map(x => x.expense);
                setProportionChart({ labels: myLabels, series: mySeries });
            });
    }, [statsId])

    const [quantityChart, setQuantityChart] = useState<QuantityChartData>({
        labels: { categories: [] },
        series: [{ name: "", data: [] }]
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/order/find-by-stats/${statsId}?size=10&sort=amountItems,desc`)
            .then((response) => {
                const data = response.data as OrderPage;
                const myLabels = data.content.map(x => x.code);
                const mySeries = data.content.map(x => x.amountItems);
                setQuantityChart({
                    labels: { categories: myLabels },
                    series: [{ name: "Quantidade de Items", data: mySeries }]
                });
            });
    }, [statsId]);

    const options = {
        plotOptions: {
            bar: { horizontal: true }
        },
        legend: { show: true }
    }

    return (
        <div className="row ">
            <div className="chart-box col-lg-6">
                <div className="container-chart">
                    <h5 className="text-center">Pedidos com maior custo</h5>
                    <Chart
                        options={{
                            ...options,
                            labels: proportionChart.labels,
                            theme: { mode: "dark" },
                            chart: { background: "#2a323a" }
                        }}
                        series={proportionChart.series}
                        type="pie"
                        height="300"
                    />
                </div>
            </div>
            <div className="chart-box col-lg-6">
                <div className="container-chart">
                    <h5 className="text-center">Pedidos com maior quantidade de items</h5>
                    <Chart
                        options={{
                            ...options,
                            xaxis: quantityChart.labels,
                            theme: { mode: "dark" },
                            colors: ["#1a6"],
                            chart: { background: "#2a323a" }
                        }}
                        labels={quantityChart.labels}
                        series={quantityChart.series}
                        type="bar"
                        height="300"
                    />
                </div>
            </div>
        </div>
    );
}

export function OrderStatsChartByCategory() {

    const [proportionChart, setProportionChart] = useState<ProportionChartData>({ labels: [], series: [] });
    useEffect(() => {
        axios.get(`${BASE_URL}/order/sum-value-by-category`)
            .then((response) => {
                const data = response.data as CategoryStatsTotalValue[];
                const myLabels = data.map(x => x.categoryName);
                const mySeries = data.map(x => x.totalValue);
                setProportionChart({ labels: myLabels, series: mySeries });
            });
    }, []);

    const [quantityChart, setQuantityChart] = useState<QuantityChartData>({
        labels: { categories: [] },
        series: [{ name: "", data: [] }]
    })
    useEffect(() => {
        axios.get(`${BASE_URL}/order/sum-quantity-by-category`)
            .then((response) => {
                const data = response.data as CategoryStatsTotalValue[];
                const myLabels = data.map(x => x.categoryName);
                const mySeries = data.map(x => x.quantity);
                setQuantityChart({
                    labels: { categories: myLabels },
                    series: [{ name: "Quantidade de Items por Pedido", data: mySeries }]
                });
            });
    }, []);

    const options = {
        legend: { show: true },
        plotOptions: { bar: { horizontal: true } }
    }

    return (
        <div className="row ">
            <div className="chart-box col-lg-6">
                <div className="container-chart">
                    <h5 className="text-center">Despesas por Categoria</h5>
                    <Chart
                        options={{
                            ...options,
                            labels: proportionChart.labels,
                            theme: { mode: "dark" },
                            chart: { background: "#2a323a" }
                        }}
                        series={proportionChart.series}
                        type="donut"
                        height="300"
                    />
                </div>
            </div>
            <div className="chart-box col-lg-6">
                <div className="container-chart">
                    <h5 className="text-center">Quantidade de Items por Categoria</h5>
                    <Chart
                        options={{
                            ...options,
                            xaxis: quantityChart.labels,
                            theme: { mode: "dark" },
                            chart: { background: "#2a323a" },
                            grid: { borderColor: "#139acf" }

                        }}
                        labels={quantityChart.labels}
                        series={quantityChart.series}
                        type="bar"
                        height="300"
                    />
                </div>
            </div>
        </div>
    );
}

export function CategoryStatsChart() {

    const [proportionChart, setProportionChart] = useState<ProportionChartData>({ labels: [], series: [] });
    useEffect(() => {
        axios.get(`${BASE_URL}/category-stats/value-of-category`)
            .then((response) => {
                const data = response.data as CategoryStatsTotalValue[];
                const myLabels = data.map(x => x.categoryName);
                const mySeries = data.map(x => x.totalValue);
                setProportionChart({ labels: myLabels, series: mySeries })
            });
    }, []);

    const [quantityChart, setQuantityChart] = useState<QuantityChartData>({ labels: { categories: [] }, series: [{ name: "", data: [] }] });
    useEffect(() => {
        axios.get(`${BASE_URL}/category-stats/product-quantity-of-category`)
            .then((response) => {
                const data = response.data as CategoryStatsTotalValue[];
                const myLabels = data.map(x => x.categoryName);
                const mySeries = data.map(x => x.quantity);
                setQuantityChart({
                    labels: { categories: myLabels },
                    series: [{ name: "Total de Unidades", data: mySeries }]
                });
            });
    }, []);

    const opitions = {
        legends: { show: true },
        plotOptions: {
            bar: { horizontal: true }
        }
    }

    return (
        <div className="row ">
            <div className="chart-box col-lg-6">
                <div className="container-chart">
                    <h5 className="text-center">Expectativa de Renda Por Categoria</h5>
                    <Chart
                        options={{
                            ...opitions,
                            labels: proportionChart.labels,
                            theme: { mode: "dark" },
                            chart: { background: "#2a323a" },
                            grid: { borderColor: "#139acf" },
                        }}
                        series={proportionChart.series}
                        type="donut"
                        height="300"
                    />
                </div>
            </div>
            <div className="chart-box col-lg-6">
                <div className="container-chart">
                    <h5 className="text-center">Unidades de Produtos Por Categoria</h5>
                    <Chart
                        options={{
                            ...opitions,
                            xaxis: quantityChart.labels,
                            theme: { mode: "dark" },
                            chart: { background: "#2a323a" },
                            grid: { borderColor: "#139acf" },
                        }}
                        labels={quantityChart.labels}
                        series={quantityChart.series}
                        type="bar"
                        height="300"
                    />
                </div>
            </div>
        </div>
    );
}

