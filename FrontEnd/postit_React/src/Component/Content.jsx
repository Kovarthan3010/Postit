import { useEffect, useState } from "react";
import axios from "axios";
import bootstrap from 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from "react-router-dom";
function Content() {
    const [posts, setPosts] = useState([]);


    const getAllposts = () => {
        axios.get('http://localhost:8080/postings')
            .then(res => {
                setPosts(res.data);
            })
            .catch(err => console.log(err))
    }


    useEffect(getAllposts, [posts]);

    const increaselikes = (id) => {
        axios.put('http://localhost:8080/update/rating/' + id)
            .then({ getAllposts })
            .catch((err) => console.log(err))
    }

    return (
        <>
            <div className="container">
                <div className="row">
                    <div className="col">
                        {posts.map((post) => {
                            return (
                                <>
                                    <div className="row border m-1 rounded border-secondary">
                                        <p className="h3 text-primary">{post.title}</p>
                                        <div className="text-wrap text-break">
                                            <p>{post.items}</p>
                                        </div>

                                        <div className="row">
                                            <div className="p col-sm h5  text-success">Author :&nbsp;{post.author}</div>
                                            <div className="col-sm d-flex justify-content-between">
                                                <div className="p text-primary">Likes : &nbsp;{post.rating}</div>
                                                <button className="btn btn-primary mb-3" onClick={() => increaselikes(post.id)}>Like</button>
                                            </div>
                                        </div>

                                    </div>

                                </>
                            );
                        })
                        }

                    </div>
                </div>
                <div className="footer mb-3">
                    <div className="d-flex justify-content-around">
                        <Link to="/">Home</Link>
                        <Link to="/searchbytitle">Search By Title</Link>
                        <Link to="/searchbyauthor">Search By Author</Link>
                    </div>
                </div>
            </div>
        </>
    )
}

export default Content