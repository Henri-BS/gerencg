import axios from "axios";
import { useState, useEffect } from "react";
import { QuantityTimelineChart } from "types/product";
import { BASE_URL } from "utils/requests";
import Chart from 'react-apexcharts'

type SeriesData = {
    name: string;
    data: number[];
}

type QuantityChartData = {
    labels: string[];
    series: SeriesData[];
}

export function QuantityProductChart() {

    const [chartData, setChartData] = useState<QuantityChartData>({
        labels: [],
        series: [
            {
                name: "",
                data: []
            }
        ]

    });

    useEffect(() => {

        axios.get(`${BASE_URL}/history/quantity-timeline`)
            .then((response) => {
                const data = response.data as QuantityTimelineChart[];
                const myLabels = data.map(x => x.date);
                const mySeries = data.map(x => x.quantity);

                setChartData({
                    labels: myLabels,
                    series: [{
                        name: "Quantidade",
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
                xaxis: {
                    labels: {
                        datetimeFormatter: {
                            year: 'yyyy',
                            month: 'MMM \'yy',
                        }
                    }
                },
                labels: chartData.labels,
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


