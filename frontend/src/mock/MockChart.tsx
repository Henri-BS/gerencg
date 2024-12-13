import {   orderChartMockdata, productChartMockdata, categoryChartMockdata } from "./MockData";
import Chart from 'react-apexcharts'


export function OrderStatsMockCharts() {

    const options = {
        legend: { show: true }
    }

    return (
        <>
            {orderChartMockdata.map((orderChart, index) => {
                return (
                    <div className="row ">
                    <div key={index} className="chart-box col-lg-6">
                        <div className="container-chart">
                            <h5 className="text-center">Custo Total de Pedidos por Mês</h5>
                            <Chart
                                options={{
                                    ...options,
                                    labels: orderChart.proportionLabels,
                                    theme: { mode: "dark" },
                                    chart: { background: "#2a323a" }
                                }}
                                series={orderChart.proportionSeries}
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
                                    xaxis: orderChart.quantityLabels,
                                    theme: { mode: "dark" },
                                    colors: ["#1a6"],
                                    chart: { background: "#2a323a" },
                                    grid: { borderColor: "#139acf" },
                                }}
                                labels={orderChart.quantityLabels}
                                series={orderChart.quantitySeries}
                                type="bar"
                                height="300"
                            />
                        </div>
                    </div>
                    </div>
                )
            })
            }
        </>
    );
}



export function OrderStatsByCategoryMockCharts() {

    const options = {
        plotOptions: {
            bar: { horizontal: true }
        },
        legend: { show: true }
    }

    return (
        <>
            {categoryChartMockdata.map((orderChart, index) => {
                return (
                    <div className="row">
                        <div key={index} className="chart-box col-lg-6">
                            <div className="container-chart">
                                <h5 className="text-center">Pedidos com maior custo</h5>
                                <Chart
                                    options={{
                                        ...options,
                                        labels: orderChart.proportionLabels,
                                        theme: { mode: "dark" },
                                        chart: { background: "#2a323a" }
                                    }}
                                    series={orderChart.proportionSeries}
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
                                        xaxis: orderChart.quantityLabels,
                                        theme: { mode: "dark" },
                                        colors: ["#1a6"],
                                        chart: { background: "#2a323a" }
                                    }}
                                    labels={orderChart.quantityLabels}
                                    series={orderChart.qunatitySeries}
                                    type="bar"
                                    height="300"
                                />
                            </div>
                        </div>
                    </div>
                )
            })}

        </>
    );
}

export function QuantityProductMockChart() {

    const opitions = {
        plotOptions: {

            bar: { horizontal: true }
        },
    }

    return (
        <>
            {productChartMockdata.map((chartData, index) => {
                return (
                    <div key={index}>
                        <Chart
                            options={{
                                ...opitions,
                                labels: chartData.labels,
                                theme: { mode: "dark" },
                                colors: ["#1a6"],
                                chart: { background: "#2a323a" },
                                grid: { borderColor: "#139acf" },
                            }}
                            labels={chartData.labels}
                            series={chartData.series}
                            type="line"
                            height="300" />
                    </div>
                )
            })}
        </>
    );
}

