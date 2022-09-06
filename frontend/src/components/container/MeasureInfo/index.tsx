import axios from "axios";
import { useEffect, useState } from "react";
import { Measure } from "types/measure";
import { BASE_URL } from "utils/requests";
import "./styles.css"

type Props = {
    measureId: string;
}

function MeasureInfo({ measureId }: Props) {

    const [measure, setMeasure] = useState<Measure>();

    useEffect(() => {
        axios.get(`${BASE_URL}/measure/${measureId}`)
            .then((response) => {
                setMeasure(response.data);
            })
    }, [measureId])

    return (
        <>
            <div className="container">
                <div className="measure-details-container">
                    <div className="measure-details-box">
                        <h3>{measure?.abbreviation}</h3>
                    </div>
                    <div className="measure-details-box">
                        <h3>{measure?.description}</h3>
                    </div>
                </div>
            </div>
        </>
    );

}



export default MeasureInfo;