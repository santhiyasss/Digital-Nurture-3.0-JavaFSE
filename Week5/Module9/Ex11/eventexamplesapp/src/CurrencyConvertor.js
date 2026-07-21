import React from 'react';

class CurrencyConvertor extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            amount: 0
        };
    }

    handleChange = (event) => {
        this.setState({ amount: event.target.value });
    }

    handleSubmit = () => {
        const rate = 3200;
        const result = this.state.amount * rate;
        alert('Converting to Euro Amount is: ' + result);
    }

    render() {
        return (
            <div>
                <h2>Currency Convertor!!!</h2>
                <label>Amount: </label>
                <input type="number" value={this.state.amount} onChange={this.handleChange} />
                <br />
                <label>Currency: INR</label>
                <br />
                <button onClick={this.handleSubmit}>Convert</button>
            </div>
        );
    }
}

export default CurrencyConvertor;