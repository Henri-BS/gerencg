import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Measure, MeasureProps } from "types/measure";
import { BASE_URL } from "utils/requests";
import { Props } from "types/page";

export function MeasureInfo({ id: measureId }: Props) {

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


export function MeasureCard({ measure }: MeasureProps) {
    return (
        <Link to={`/measure/${measure.abbreviation}`} className="text-decoration-none">
            <abbr title={measure.abbreviation}>
                <div className="tag-card-container ">
                    {measure.description}
                </div>
            </abbr>
        </Link>
    );
}





