function Scorebelow70({ players }) {
    let players70 = [];
    players.map((item) => {
        if (item.score <= 70) {
            players70.push(item);
        }
    });

    return (
        <div>
            {players70.map((item) => {
                return (
                    <div key={item.name}>
                        <li>Mr. {item.name} <span> {item.score} </span></li>
                    </div>
                )
            })}
        </div>
    );
}

export default Scorebelow70;