import axios from "axios";
import { toast } from "react-toastify";
import icon from "../../assets/img/notification-icon.svg";
import { BASE_URL } from "../../utils/request";
import "./styles.css";

type Props = {
  saleId: number;
};

function handleClick(id: number) {
  axios(`${BASE_URL}/sales/${id}/notification`).then((reponse) => {
    toast.info("SMS enviado com sucesso.");
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
