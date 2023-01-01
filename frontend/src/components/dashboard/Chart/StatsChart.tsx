import axios from 'axios';
import { useState, useEffect } from 'react';
import Chart from 'react-apexcharts'
import { CategoryValue, FlowCategory } from 'types/category';
import { CodePage, OrderStats, OrderStatsPage, OrderStatsProps, OrderStatsQuantityGroup, OrderStatsValueGroup } from 'types/order';
import { BASE_URL } from 'utils/requests';
import { QuantityProductChart } from './ProductCharts';

/**  Periodic income record of each category */

type ProportionChartData = {
    labels: string[];
    series: number[];
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
export function IncomeChart() {

    const [chartData, setChartData] = useState<ProportionChartData>({ labels: [], series: [] });

    useEffect(() => {
        axios.get(`${BASE_URL}/category-stats/value-of-category`)
            .then(response => {
                const data = response.data as CategoryValue[];
                const myLabels = data.map(x => x.categoryName);
                const mySeries = data.map(x => x.income);

                setChartData({ labels: myLabels, series: mySeries });
            });
    }, []);

    const options = {
        legend: { show: true }
    }

    return (
        <Chart
            options={{
                ...options,
                labels: chartData.labels,
                theme: { mode: "dark" },
                chart: { background: "#2a323a" }
            }}
            series={chartData.series}
            type="pie"
            height="300"
        />
    );
}

/**  Periodic expense record of each category */

export function ExpenseChart() {

    const [chartData, setChartData] = useState<ProportionChartData>({ labels: [], series: [] });

    useEffect(() => {
        axios.get(`${BASE_URL}/category-stats/value-of-category`)
            .then(response => {
                const data = response.data as CategoryValue[];
                const myLabels = data.map(x => x.categoryName);
                const mySeries = data.map(x => x.expense);

                setChartData({ labels: myLabels, series: mySeries });
            });
    }, []);

    const options = {
        legend: { show: true }
    }

    return (
        <Chart
            options={{
                ...options,
                labels: chartData.labels,
                theme: { mode: "dark" },
                chart: { background: "#2a323a" }
            }}
            series={chartData.series}
            type="donut"
            height="300"
        />
    );
}

export function OrderStatsValueChart() {
    const [chartData, setChartData] = useState<ProportionChartData>({ labels: [], series: [] });

    useEffect(() => {
        axios.get(`${BASE_URL}/order-stats/sum-order-value`)
            .then((response) => {
                const data = response.data as OrderStatsValueGroup[];
                const myLabels = data.map(x => x.date);
                const mySeries = data.map(x => x.value);
                setChartData({ labels: myLabels, series: mySeries });
            });
    }, []);

    const options = {
        legend: { show: true }
    }

    return (
        <Chart
            options={{
                ...options,
                labels: chartData.labels,
                theme: { mode: "dark" },
                chart: { background: "#2a323a" }
            }}
            series={chartData.series}
            type="pie"
            height="300"
        />
    );
}

export function OrderStatsChartsByPediod({ statsId }: OrderStatsProps) {
    const [chartData, setChartData] = useState<ProportionChartData>({ labels: [], series: [] });
    const [quantityChart, setQuantityChart] = useState<QuantityChartData>({
        labels: { categories: [] },
        series: [{ name: "", data: [] }]
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/find-order-by-stats/${statsId}?size=10&sort=totalValue`)
            .then((response) => {
                const data = response.data as CodePage;
                const myLabels = data.content?.map(x => x.code);
                const mySeries = data.content?.map(x => x.totalValue);
                setChartData({ labels: myLabels, series: mySeries });
            });
    }, [statsId])

    useEffect(() => {
        axios.get(`${BASE_URL}/find-order-by-stats/${statsId}?size=10&sort=amountItems,desc`)
            .then((response) => {
                const data = response.data as CodePage;
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
            bar:{horizontal: true} 
        }
    }

    return (
        <div className="row ">
            <div className="chart-box col-lg-6">
                <div className="container-chart">
                    <h5 className="text-center">Pedidos com maior custo</h5>
                    <Chart
                        options={{
                            ...options,
                            labels: chartData.labels,
                            theme: { mode: "dark" },
                            chart: { background: "#2a323a" }
                        }}
                        series={chartData.series}
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


// Periodic added products registration of each category 



export function OrderStatsQuantityChart() {
    const [chartData, setChartData] = useState<QuantityChartData>({
        labels: { categories: [] },
        series: [{ name: "", data: [] }]
    });
    useEffect(() => {
        axios.get(`${BASE_URL}/order-stats/sum-order-quantity`)
            .then((response) => {
                const data = response.data as OrderStatsQuantityGroup[];
                const myLabels = data.map(x => x.statsId);
                const mySeries = data.map(x => x.sumOrders);
                setChartData({
                    labels: { categories: myLabels },
                    series: [{ name: "Quantidade de Pedidos", data: mySeries }]
                });
            });
    }, []);
    const opt = {
        plotOptions: {
            bar: { horizontal: true }
        }
    }
    return (
        <Chart
            options={{
                ...opt,
                xaxis: chartData.labels,
                theme: { mode: "dark" },
                colors: ["#1a6"],
                chart: { background: "#2a323a" },
                grid: { borderColor: "#139acf" },
            }}
            labels={chartData.labels}
            series={chartData.series}
            type="line"
            height="300"
        />
    );
}

export function AddedProductsChart() {

    const [chartData, setChartData] = useState<QuantityChartData>({

        labels: {
            categories: []
        },

        series: [
            {
                name: "",
                data: []
            }
        ]

    });

    useEffect(() => {

        axios.get(`${BASE_URL}/category-stats/flow-of-category`)
            .then((response) => {
                const data = response.data as FlowCategory[];
                const myLabels = data.map(x => x.categoryName);
                const mySeries = data.map(x => x.addedProduct);

                setChartData({
                    labels: { categories: myLabels },
                    series: [{
                        name: "Adicionados",
                        data: mySeries
                    }]
                });
            });
    }, []);

    const opitions = {
        plotOptions: {
            bar: { horizontal: true }
        }
    }

    return (
        <Chart
            options={{
                ...opitions,
                xaxis: chartData.labels,
                theme: { mode: "dark" },
                colors: ["#1a6"],
                chart: { background: "#2a323a" },
                grid: { borderColor: "#139acf" },
            }}
            labels={chartData.labels}
            series={chartData.series}
            type="bar"
            height="300"
        />
    );
}


/** Periodic removed products registration of each category */
export function RemovedProductsChart() {
    const [chartData, setChartData] = useState<QuantityChartData>({

        labels: { categories: [] },

        series: [{
            name: "",
            data: []
        }]
    });

    useEffect(() => {

        axios.get(`${BASE_URL}/category-stats/flow-of-category`)
            .then(response => {
                const data = response.data as FlowCategory[];
                const myLabels = data.map(x => x.categoryName);
                const mySeries = data.map(x => x.removedProduct);

                setChartData({
                    labels: { categories: myLabels },
                    series: [{
                        name: "Removidos",
                        data: mySeries
                    }]
                });
            });
    }, []);

    const opitions = {
        plotOptions: {
            bar: { horizontal: true }
        },
    }

    return (
        <Chart
            options={{
                ...opitions,
                xaxis: chartData.labels,

                theme: { mode: "dark" },

                colors: ["#ad1321"],

                chart: { background: "#2a323a" },

                grid: { borderColor: "#139acf" },
            }}
            labels={chartData.labels}
            series={chartData.series}
            type="bar"
            height="300"
        />
    );
}