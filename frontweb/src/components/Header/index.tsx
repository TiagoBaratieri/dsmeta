import logo from "../../assets/img/logo.svg";
import "./styles.css";

const Header = () => {
  return (
    <header>
      <div className="dsmeta-logo-container">
        <img src={logo} alt="dsmeta" />
        <h1>Ds Meta</h1>
        <p>
          Desenvolvido por 
          <a href="https://www.linkedin.com/in/tiago-lemos-baratieri-a95b0a206">
            Tiago Baratieri
          </a>
        </p>
      </div>
    </header>
  );
};

export default Header;