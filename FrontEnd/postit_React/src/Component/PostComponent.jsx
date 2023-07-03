import axios from "axios";
import { useState, event } from "react";
import { Link } from "react-router-dom";

function PostComponent() {
    const [flag, setFlag] = useState(false);
    const [title, setTitle] = useState("");
    const [author, setAuthor] = useState("");
    const [item, setItem] = useState("");
    const [message, setMessage] = useState("");
    const handletitle = (event) => {
        setTitle(event.target.value);
        setFlag(false);
    }
    const handleauthor = (event) => {
        setAuthor(event.target.value);
        setFlag(false);
    }
    const handleitem = (event) => {
        setItem(event.target.value);
        setFlag(false);
    }


    const handlepost = (event) => {
        let posting = {
            "title": "",
            "author": "",
            "items": "",
            "rating": 0,
        };
        event.preventDefault();
        posting.title = title;
        posting.author = author;
        posting.items = item;

        axios.post('http://localhost:8080/post', posting).then(
            setFlag(true)
        )
        setAuthor("");
        setItem("");
        setTitle("");

    }
    return (
        <>
            <div className="container position-absolute top-50 start-50 translate-middle border rounded border-primary bg-light">
                <form className="form" onSubmit={handlepost}>
                    <div className="formgroup">
                        <label htmlFor="title" className="text-primary">Title : </label>
                        <input type="text" id="title" value={title} onChange={handletitle} className="form-control mt-2 mb-2" placeholder="@ Enter Title for your post" />
                    </div>
                    <div className="formgroup">
                        <label htmlFor="author" className="text-primary">Author Name : </label>
                        <input type="text" id="author" value={author} onChange={handleauthor} className="form-control mt-2 mb-2" placeholder="@ Enter Author Name" />
                    </div>
                    <div className="formgroup">
                        <label htmlFor="content" className="text-primary">Content : </label>
                        <textarea rows="10" id="content" value={item} onChange={handleitem} className="form-control mt-2 mb-2" placeholder="@ Type your content" />
                    </div>
                    <br />
                    <div className="d-flex justify-content-between">
                        <button className="btn btn-primary mb-3">Post</button>
                        <Link to="/">Home</Link>
                    </div>
                </form>
                {flag ?
                    (<div>
                        <p className="text-success">Posted successfully!!!</p>
                    </div>) :
                    (<p className="text-danger">Please fill all details!!!</p>)
                }
            </div>
            <div className="footer bg-light">
                <div className="d-flex justify-content-around">
                    <Link to="/">Home</Link>
                    <Link to="/searchbytitle">Search By Title</Link>
                    <Link to="/searchbyauthor">Search By Author</Link>
                </div>
            </div>
        </>
    )
}
export default PostComponent