import React from 'react';
import './App.css';

const books = [
    { id: 101, bname: 'Master React', price: 670 },
    { id: 102, bname: 'Deep Dive into Angular 11', price: 800 },
    { id: 103, bname: 'Mongo Essentials', price: 450 },
];

const courses = [
    { id: 1, cname: 'Angular', cdate: '4/5/2021' },
    { id: 2, cname: 'React', cdate: '6/3/2021' },
];

const blog = {
    title: 'React Learning',
    author: 'Stephen Biz',
    heading: 'Welcome to learning React!',
    subheading: 'Installation',
    content: 'You can install React from npm.'
};

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            showBooks: true,
            showBlog: true,
            showCourses: true
        };
    }

    render() {
        // 1. Conditional rendering using an element variable + if/else
        let bookdet;
        if (this.state.showBooks) {
            bookdet = (
                <ul>
                    {books.map((book) => (
                        <div key={book.id}>
                            <h3>{book.bname}</h3>
                            <h4>{book.price}</h4>
                        </div>
                    ))}
                </ul>
            );
        } else {
            bookdet = <p>No books available</p>;
        }

        // 2. Conditional rendering using the ternary operator
        const content = this.state.showBlog ? (
            <div>
                <h3>{blog.title}</h3>
                <h4>{blog.author}</h4>
                <h4>{blog.heading}</h4>
                <h5>{blog.subheading}</h5>
                <p>{blog.content}</p>
            </div>
        ) : (
            <p>No blogs available</p>
        );

        return (
            <div>
                <div>
                    <div className="st2">
                        <h1> Book Details</h1>
                        {bookdet}
                    </div>
                    <div className="v1">
                        <h1> Blog Details</h1>
                        {content}
                    </div>
                    <div className="mystyle1">
                        <h1> Course Details</h1>
                        {/* 3. Conditional rendering using && short-circuit */}
                        {this.state.showCourses && (
                            <ul>
                                {courses.map((course) => (
                                    <div key={course.id}>
                                        <h3>{course.cname}</h3>
                                        <h4>{course.cdate}</h4>
                                    </div>
                                ))}
                            </ul>
                        )}
                    </div>
                </div>
            </div>
        );
    }
}

export default App;