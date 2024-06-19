import styles from "../css/footer.module.css";

const Footer = () => {
    return (
        <footer>
            <div className="button">
                <p>Send me an <span className={`${styles.email} text-uppercase`}>email</span></p>
            </div>
        </footer>
    );
};

export default Footer;