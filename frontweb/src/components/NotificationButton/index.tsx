import axios from "axios";
import icon from "../../assets/img/notification-icon.svg";
import { BASE_URL } from "../../utils/request";
import "./styles.css";

type Props = {
  saleId: number;
};

function handleClick(id: number) {
  axios(`${BASE_URL}/sales/${id}/notification`).then((reponse) => {
    console.log("Sucesso");
  });
}
const NotificationButton = ({ saleId }: Props) => {
  return (
    <div className="dsmeta-red-btn">
      <img src={icon} alt="Notificar" onClick={() => handleClick(saleId)} />
    </div>
  );
};

export default NotificationButton;
