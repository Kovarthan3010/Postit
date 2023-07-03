import bootstrap from 'bootstrap/dist/css/bootstrap.min.css'
import { Link } from 'react-router-dom'
function HomeComponent() {
    return (
        <>
            <div className="container">
                <div className="row bg-light">
                    <div className="col-md bg-light">
                        <div className="d-flex mt-1">
                            <h1 className="fst-italic">Post it</h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <Link to="/addpost" className='mt-3'>Add Post</Link>&nbsp;&nbsp;&nbsp;

                        </div>
                    </div>
                    <div className="col-md bg-light d-flex justify-content-around">
                        <Link to="/searchbyauthor" className='mt-3'>Search by Author</Link>
                        <Link to="/searchbytitle" className='mt-3'>Search by Title</Link>
                        <Link to="/login" className='mt-3'>Login</Link>
                        <Link to="/signup" className='mt-3'>Sign Up</Link>


                    </div>
                </div>
            </div>
        </>
    )
}
export default HomeComponent