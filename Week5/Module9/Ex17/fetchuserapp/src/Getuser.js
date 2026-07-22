import React from 'react';

class Getuser extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            person: {},
            loading: true
        };
    }

    async componentDidMount() {
        const url = "https://api.randomuser.me/";
        const response = await fetch(url);
        const data = await response.json();
        this.setState({ person: data.results[0], loading: false });
        console.log(data.results[0]);
    }

    render() {
        if (this.state.loading) {
            return <h2>Loading...</h2>;
        }
        return (
            <div>
                <h2>Title: {this.state.person.name.title}</h2>
                <h2>First Name: {this.state.person.name.first}</h2>
                <img src={this.state.person.picture.large} alt="user" />
            </div>
        );
    }
}

export default Getuser;