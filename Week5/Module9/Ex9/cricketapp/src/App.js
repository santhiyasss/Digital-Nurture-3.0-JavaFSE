import ListofPlayers from './ListofPlayers';
import Scorebelow70 from './Scorebelow70';
import { IndianTeam, OddPlayers, EvenPlayers, IndianPlayers, ListofIndianPlayers } from './IndianPlayers';

function App() {
    const players = [
        { name: 'Rohit', score: 85 },
        { name: 'Virat', score: 92 },
        { name: 'Rahul', score: 65 },
        { name: 'Rishabh', score: 55 },
        { name: 'Hardik', score: 78 },
        { name: 'Ravindra', score: 40 },
        { name: 'Shami', score: 12 },
        { name: 'Bumrah', score: 8 },
        { name: 'Kuldeep', score: 15 },
        { name: 'Shubman', score: 60 },
        { name: 'Suryakumar', score: 70 }
    ];

    var flag = false;

    if (flag === true) {
        return (
            <div>
                <h1> List of Players</h1>
                <ListofPlayers players={players} />
                <hr />
                <h1> List of Players having Scores Less than 70 </h1>
                <Scorebelow70 players={players} />
            </div>
        )
    } else {
        return (
            <div>
                <div>
                    <h1> Indian Team </h1>
                    <h1> Odd Players </h1>
                    {OddPlayers(IndianTeam)}
                    <hr />
                    <h1> Even Players</h1>
                    {EvenPlayers(IndianTeam)}
                </div>
                <hr />
                <div>
                    <h1> List of Indian Players Merged:</h1>
                    <ListofIndianPlayers IndianPlayers={IndianPlayers} />
                </div>
            </div>
        )
    }
}

export default App;