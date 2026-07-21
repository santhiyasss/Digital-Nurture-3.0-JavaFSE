import './App.css';

function App() {
    const element = "Office Space";
    const src = "https://via.placeholder.com/300x200?text=Office+Space";
    const jsxatt = <img src={src} width="25%" height="25%" alt="Office Space" />;
    const ItemName = { Name: "DBS", Rent: 50000, Address: "Chennai" };

    const officeList = [
        { Name: "DBS", Rent: 50000, Address: "Chennai" },
        { Name: "TCS", Rent: 75000, Address: "Bangalore" },
        { Name: "Infosys", Rent: 45000, Address: "Hyderabad" },
        { Name: "Wipro", Rent: 68000, Address: "Pune" }
    ];

    let colors = [];
    officeList.map((item) => {
        if (item.Rent <= 60000) {
            colors.push('textRed');
        } else {
            colors.push('textGreen');
        }
        return null;
    });

    return (
        <div>
            <h1>{element} , at Affordable Range </h1>
            {jsxatt}
            <h1>Name: {ItemName.Name}</h1>
            <h3> Rent: Rs. {ItemName.Rent}</h3>
            <h3> Address: {ItemName.Address}</h3>
            <hr />
            {officeList.map((item, index) => (
                <div key={item.Name}>
                    <h2>Name: {item.Name}</h2>
                    <h3 className={colors[index]}>Rent: Rs. {item.Rent}</h3>
                    <h3>Address: {item.Address}</h3>
                </div>
            ))}
        </div>
    );
}

export default App;