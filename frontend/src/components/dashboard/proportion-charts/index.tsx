import axios from 'axios';
import { useState, useEffect } from 'react';
import Chart from 'react-apexcharts'
import { CategoryValue } from 'types/categoryStats';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    labels: string[];
    series: number[];
}

export function IncomeChart() {

    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });

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
        legend: {
            show: true,
        },
    }

    return (
        <Chart
            options={{
                ...options, 
                labels: chartData.labels,

                theme: {
                    mode: "dark"
                }
            }}
            series={chartData.series}
            type="pie"
            height="240"
        />
    );
}

export function ExpenseChart() {

    const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });

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
        legend: {
            show: true,
        },
    }

    return (
        <Chart
            options={{
                ...options, labels: chartData.labels,
                theme: {
                    mode: "dark"
                }
            }}
            series={chartData.series}
            type="donut"
            height="240"

        />
    );
}