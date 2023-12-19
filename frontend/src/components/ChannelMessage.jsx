import styles from '@/styles/channelMessage.module.css';

function formatDate(ISOdate) {
	const date = new Date(ISOdate);
	// const day = date.getDate().toString().padStart(2, '0');
	// const month = (date.getMonth() + 1).toString().padStart(2, '0');
	// const year = date.getFullYear().toString().slice(2);

	const hours = date.getHours().toString().padStart(2, '0');
	const minutes = date.getMinutes().toString().padStart(2, '0');

	//return `${day}/${month}/${year} ${hours}:${minutes}`;
	return `${hours}:${minutes}`;
}

const ChannelMessage = ({ msg }) => {
	const { comments, userName, localDateTime } = msg;

	// Check if msg is a gif
	const gifRegex = /\[giphy\](.*?)\[\/giphy\]/;
	const match = (comments ?? '').match(gifRegex);

	return (
		<div className={styles.message_container}>
			<div className={styles.image_container}>
				<img src="/images/no-photo-user-icon.png" className={styles.image} />
			</div>
			<div className={styles.message}>
				<div className={styles.username}>
					<b>{userName}</b>
					<span className={styles.date_time}>{formatDate(localDateTime)}</span>
				</div>
				{match ? (
					<img src={match[1]} alt="GIF" className={styles.gif_image} />
				) : (
					<span className={styles.message_text}>{comments}</span>
				)}
			</div>
		</div>
	);
};

export default ChannelMessage;
