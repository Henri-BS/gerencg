//Gráfico referente ao fluxo de entrada e saida de produtos de cada categoria
import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts'
import { FlowCategory } from 'types/detail';
import { round } from 'utils/format';
import { BASE_URL } from 'utils/requests';

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

const BarChart = () => {

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

        axios.get(`${BASE_URL}/details/flow-of-category`)
            .then(response => {
                const data = response.data as FlowCategory[];
                const myLabels = data.map(x => x.categoryName);
                const mySeries = data.map(x => round(100.0 * x.prod_adc / x.prod_remov, 1));

                setChartData({
                    labels: {
                        categories: myLabels
                    },
                    series: [
                        {
                            name: "% Fluxo",
                            data: mySeries
                        }
                    ]
                });
            });
    }, []);

    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };

    return (
        <Chart
            options={{ ...options, xaxis: chartData.labels }}
            series={chartData.series}
            type="bar"
            height="240"
        />

    );
}

export default BarChart;