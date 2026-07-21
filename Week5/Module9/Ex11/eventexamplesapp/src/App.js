import React from 'react';
import CurrencyConvertor from './CurrencyConvertor';

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            count: 0
        };
    }

    increment = () => {
        this.setState((prevState) => ({ count: prevState.count + 1 }));
        this.sayHello();
    }

    decrement = () => {
        this.setState((prevState) => ({ count: prevState.count - 1 }));
    }

    sayHello = () => {
        alert('Hello Member!');
    }

    sayWelcome = (msg) => {
        alert(msg);
    }

    handleClick = (event) => {
        alert('I was clicked');
    }

    render() {
        return (
            <div>
                <h2>Counter: {this.state.count}</h2>
                <button onClick={this.increment}>Increment</button>
                <button onClick={this.decrement}>Decrement</button>
                <button onClick={() => this.sayWelcome('welcome')}>Say Welcome</button>
                <button onClick={this.handleClick}>Click on me</button>
                <hr />
                <CurrencyConvertor />
            </div>
        );
    }
}

export default App;