const root = ReactDOM.createRoot(document.getElementById("root"));

const Champion = ({ name, years }) => {
    return (
        <div style={{ border: '1px solid black' }}>
            <h1 style={{ textAlign: 'center' }}>Имя чемпиона: {name}</h1>
            <p style={{ textAlign: 'center', marginBottom: '60px' }}>Года чемпионства: {years}</p>
        </div>
    )
}

const champions = [
    { name:"Вильгельм Стейниц", years:"1886-1894" },
    { name:"Эмануэль Ласкер", years: "1894-1921" },
    { name:"Хосе Рауль Капабланка", years:"1921-1927" },
    { name:"Александр Алехин", years:"1927-1935, 1937-1946" },
    { name:"Макс Эйве", years:"1935-1937" },
    { name:"Михаил Ботвинник", years:"1948-1957, 1958-1960, 1961-1963" },
    { name:"Василий Смыслов", years:"1957-1958" },
    { name:"Михаил Таль", years:"1960-1961" },
    { name:"Тигран Петросян", years:"1963-1969" },
    { name:"Борис Спасский", years:"1969-1972" },
    { name:"Бобби Фишер", years:"1972-1975" },
    { name:"Анатолий Карпов", years:"1975-1985" },
    { name:"Гарри Каспаров", years:"1985-2000" }
];

root.render(
    <>
      { champions.map((e, i) => (
        <Champion
            key={i}
            name={e.name}
            years={e.years}
        />
      )) }
    </>
  );