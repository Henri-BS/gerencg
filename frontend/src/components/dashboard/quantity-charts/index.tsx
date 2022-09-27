import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts'
import { FlowCategory } from 'types/categoryStats';
import { BASE_URL } from 'utils/requests';

// Chart Added Products in Category

type SeriesData = {
    name: string;
    data: number[];
}

type ChartData = {
    labels: {
        categories: string[];
    };
    series: SeriesData[];
}

export function AddedProductsChart() {

    const [chartData, setChartData] = useState<ChartData>({

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
            .then(response => {
                const data = response.data as FlowCategory[];
                const myLabels = data.map(x => x.categoryName);
                const mySeries = data.map(x => x.addedProduct);

                setChartData({
                    labels: {
                        categories: myLabels

                    },
                    series: [
                        {
                            name: "Adicionados",
                            data: mySeries
                        }
                    ]
                });
            });
    }, []);

    const opitions = {
        plotOptions: {

            bar: {
                horizontal: true,
            },

        },
    }

    return (
        <Chart
            options={{
                ...opitions,
                xaxis: chartData.labels,
                
                theme: {
                    mode: "dark"
                },
                colors: ["#1a6"],
                chart: {
                    background: "#2a323a"                    
                },

                grid: {
                    borderColor: "#139acf"
                },
            }}
            labels={chartData.labels}
            series={chartData.series}
            type="bar"
            height="300"
        />

    );
}



export function RemovedProductsChart() {
    const [chartData, setChartData] = useState<ChartData>({

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
            .then(response => {
                const data = response.data as FlowCategory[];
                const myLabels = data.map(x => x.categoryName);
                const mySeries = data.map(x => x.removedProduct);

                setChartData({
                    labels: {
                        categories: myLabels
                    },
                    series: [
                        {
                            name: "Removidos",
                            data: mySeries
                        }
                    ]
                });
            });
    }, []);

    const opitions = {

        plotOptions: {
            bar: {
                horizontal: true
            },
    
        },

    }


    return (
        <Chart
            options={{
                ...opitions,
                xaxis: chartData.labels,
                
                theme: {
                    mode: "dark"
                },

                colors: ["#ad1321"],
                
                chart: {
                    background: "#2a323a",
                },

                grid: {
                    borderColor: "#139acf"
                },
            }}
            labels={chartData.labels}
            series={chartData.series}
            type="bar"
            height="300"
            
        />
    );


}

