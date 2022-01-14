import axios from 'axios';
import { type } from 'os'
import Chart from 'react-apexcharts'
import { CategoryValue } from 'types/details';
import { BASE_URL } from 'utils/requests';

type ChartData = {
    labels: string[];
    series: number[];
}

const DonutChart = () => {

    let chartData: ChartData = { labels: [], series: []};

    axios.get(`${BASE_URL}/details/value-of-category`)
        .then(response => {
            const data = response.data as CategoryValue[];
            const myLabels = data.map(x => x.categoryName);
            const mySeries = data.map(x => x.sum);

            chartData = { labels: myLabels, series: mySeries };
            console.log(chartData);
        });
   
    const options = {
        legend: {
            show: true,
        }
    }

    return (
        <Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="240"
        />

    );
}

export default DonutChart;