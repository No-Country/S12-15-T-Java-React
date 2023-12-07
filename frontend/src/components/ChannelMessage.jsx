import styles from '@/styles/channelMessage.module.css';

const ChannelMessage = ({ msg }) => {
	const { username, date_time, message } = msg;
	return (
		<div className={styles.message_container}>
			<div className={styles.image_container}>
				<img src="/images/no-photo-user-icon.png" className={styles.image} />
			</div>
			<div className={styles.message}>
				<div className={styles.username}>
					{username}
					<span className={styles.date_time}>{date_time}</span>
				</div>
				<span className={styles.message_text}>{message}</span>
			</div>
		</div>
	);
};

export default ChannelMessage;
