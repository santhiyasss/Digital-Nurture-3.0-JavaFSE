import React from 'react';

class CountPeople extends React.Component {
    constructor() {
        super();
        this.state = {
            entrycount: 0,
            exitcount: 0
        };
    }

    updateEntry() {
        this.setState((prevState, props) => {
            return { entrycount: prevState.entrycount + 1 }
        });
    }

    updateExit() {
        this.setState((prevState, props) => {
            return { exitcount: prevState.exitcount + 1 }
        });
    }

    render() {
        return (
            <div>
                <button onClick={() => this.updateEntry()}>Login</button>
                <button onClick={() => this.updateExit()}>Exit</button>
                <h3>{this.state.entrycount} People Entered!!!</h3>
                <h3>{this.state.exitcount} People Left!</h3>
            </div>
        );
    }
}

export default CountPeople;