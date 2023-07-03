import { useEffect, useState } from "react"
import { Link } from "react-router-dom"
import axios from "axios";
function TitlewiseComponent() {

    const [dataset, setData] = useState([]);
    const [titlevalue, setTitlevalue] = useState("");


    const titlechangehandle = (event) => {
        setTitlevalue(event.target.value)
    }


    const formhandle = (event) => {
        event.preventDefault();
        axios.get('http://localhost:8080/postingsByTitle?title=' + titlevalue)
            .then((res) => { setData(res.data) })
            .catch((err) => console.log(err))
    }
    const increaselikes = (id) => {
        axios.put('http://localhost:8080/update/rating/' + id)
            .then(() => {
                axios.get('http://localhost:8080/postingsByTitle?title=' + titlevalue)
                    .then((res) => { setData(res.data) })
                    .catch((err) => console.log(err))
            })
            .catch((err) => console.log(err))
    }
    return (
        <>
            <div className="container">
                <div className="row bg-light border rounded">

                    <div className="col-md mt-3 mb-2">
                        <Link to="/">Home</Link>
                    </div>
                    <div className="col-md d-flex">
                        <form onSubmit={formhandle} className="d-flex form-group">
                            <input type="text" value={titlevalue} onChange={titlechangehandle} className="type-text rounded" placeholder="@ Enter title" />
                            &nbsp;
                            <button type="submit" className="btn btn-primary">Search</button>
                        </form>
                    </div>
                    <div className="col-md mt-3 mb-2">
                        <Link to="/searchbyauthor" >Search By Author</Link>
                    </div>

                </div>
            </div>


            <div>
                {dataset.map((datasetvalue) => {
                    return (
                        <>
                            <div className="container">
                                <div className="row border rounded border-primary m-1 bg-light">
                                    <div className="h4 text-primary">{datasetvalue.title}</div>
                                    <div className="p text-break">{datasetvalue.items}</div>
                                    <div className="row">
                                        <div className="p col-sm h5  text-success">Author :&nbsp;{datasetvalue.author}</div>
                                        <div className="col-sm d-flex justify-content-between">
                                            <div className="p text-primary">Likes : &nbsp;{datasetvalue.rating}</div>
                                            <button className="btn btn-primary mb-3" onClick={() => increaselikes(datasetvalue.id)}>Like</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </>
                    )
                })}
            </div>


        </>
    )
}
export default TitlewiseComponent