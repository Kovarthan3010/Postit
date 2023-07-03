import { Link } from "react-router-dom"
import axios from "axios";
import { useEffect, useState } from "react";
function AuthorwiseComponent() {
    const [datasets, setDatasets] = useState([]);
    const [authorname, setAuthorname] = useState("");
    const authornamechange = (event) => {
        setAuthorname(event.target.value)
    }
    const searchHandle = (event) => {
        event.preventDefault();
        axios.get('http://localhost:8080/postingsByAuthor?author=' + authorname)
            .then(res => { setDatasets(res.data); console.log(res) })
            .catch((err) => setDatasets(err))
    }

    const increaselikes = (id) => {
        axios.put('http://localhost:8080/update/rating/' + id)
            .then(() => {
                axios.get('http://localhost:8080/postingsByAuthor?author=' + authorname)
                    .then(res => { setDatasets(res.data); console.log(res) })
                    .catch((err) => setDatasets(err))
            })
            .catch((err) => console.log(err))
    }
    return (
        <>
            <div className="container">
                <div className="row bg-light border rounded">

                    <div className="col-md mt-2 mb-2">
                        <Link to="/" >Home</Link>
                    </div>


                    <div className="col-md">
                        <form onSubmit={searchHandle} className="d-flex">
                            <input type="text" value={authorname} onChange={authornamechange} className="type-text rounded" placeholder="@ Enter Author Name" />
                            &nbsp;
                            <button type="submit" className="btn btn-primary">Search</button>
                        </form>
                    </div>
                    <div className="col-md mt-2 mb-2">
                        <Link to="/searchbytitle" className="col-md">Search By Titles</Link>
                    </div>

                </div>

            </div>
            <div>
                {
                    datasets.map(datas => {
                        return (
                            <>
                                <div className="container">
                                    <div className="row m-1">
                                        <div className="border rounded border-primary">
                                            <div className="h3 text-primary">
                                                {datas.title}
                                            </div>
                                            <div className="p text-wrap text-break">
                                                {datas.items}
                                            </div>
                                            <div className="row">
                                                <div className="p col-sm h5  text-success">Author :&nbsp;{datas.author}</div>
                                                <div className="col-sm d-flex justify-content-between">
                                                    <div className="p text-primary">Likes : &nbsp;{datas.rating}</div>
                                                    <button className="btn btn-primary mb-3" onClick={() => increaselikes(datas.id)}>Like</button>
                                                </div>
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
export default AuthorwiseComponent