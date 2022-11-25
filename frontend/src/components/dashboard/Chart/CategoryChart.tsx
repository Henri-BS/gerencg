import axios from 'axios';
import { useState, useEffect } from 'react';
import Chart from 'react-apexcharts'
import { CategoryValue, FlowCategory } from 'types/category';
import { BASE_URL } from 'utils/requests';

/**  Periodic income record of each category */

type ProportionChartData = {
    labels: string[];
    series: number[];
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

/** Periodic added products registration of each category */

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
        },
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