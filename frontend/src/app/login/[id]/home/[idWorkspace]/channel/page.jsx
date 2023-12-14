import ChannelMessage from '@/components/ChannelMessage';
import ChannelMessagesDivider from '@/components/ChannelMessagesDivider';
import ChannelWriteMessage from '@/components/ChannelWriteMessage';
import styles from '@/styles/channel.module.css';

const message = [
	{
		id: 1,
		username: 'Nombre del usuario',
		date_time: '10:45',
		message: 'Texto del usuario de lo que quiera escribir',
	},
	{
		id: 2,
		username: 'Nombre del usuario',
		date_time: '10:45',
		message: 'Texto del usuario de lo que quiera escribir',
	},
	{
		id: 3,
		username: 'Nombre del usuario',
		date_time: '10:45',
		message: 'Texto del usuario de lo que quiera escribir',
	},
	{
		id: 4,
		username: 'Nombre del usuario',
		date_time: '10:45',
		message: 'Texto del usuario de lo que quiera escribir',
	},
];

const ChannelPage = () => {
	return (
		<div className={styles.container}>
			<div className={styles.title}>
				<div>
					<img
						src="/images/chat-icon.png"
						alt="channel icon"
						className="channel_icon"
					/>
					<span>General</span>
				</div>
				<div className={styles.members}>
					14 <img src="/images/rectangle-user-icon.png" alt="members icon" />
				</div>
			</div>
			<hr />
			<div className={styles.messages}>
				{/*To-Do Map messages handling change of dates*/}
				<ChannelMessage msg={message[0]} />
				<ChannelMessage msg={message[1]} />
				<ChannelMessagesDivider date="11/11/23" />
				<ChannelMessage msg={message[2]} />
				<ChannelMessagesDivider date="Hoy" />
				<ChannelMessage msg={message[3]} />
			</div>
			<div className={styles.write_message}>
				<ChannelWriteMessage />
			</div>
		</div>
	);
};

export default ChannelPage;
