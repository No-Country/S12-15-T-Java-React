import styles from '@/styles/channelMessagesDivider.module.css';

const ChannelMessagesDivider = ({ date }) => {
	return (
		date && (
			<div className={styles.divider}>
				<hr />
				<span>{date}</span>
				<hr />
			</div>
		)
	);
};

export default ChannelMessagesDivider;
