'use client';
import ChannelMessage from '@/components/channel/ChannelMessage';
import ChannelMessagesDivider from '@/components/channel/ChannelMessagesDivider';
import ChannelWriteMessage from '@/components/channel/ChannelWriteMessage';
import styles from '@/styles/channel.module.css';
import { useState } from 'react';
const message = [
	{
		id: 1,
		username: 'Nombre del usuario',
		date: '',
		time: '10:45',
		message: 'Texto del usuario de lo que quiera escribir',
	},
	{
		id: 2,
		username: 'Nombre del usuario',
		date: '',
		time: '10:45',
		message: 'Texto del usuario de lo que quiera escribir',
	},
	{
		id: 3,
		username: 'Nombre del usuario',
		date: '',
		time: '10:45',
		message: 'Texto del usuario de lo que quiera escribir',
	},
	{
		id: 4,
		username: 'Nombre del usuario',
		date: '',
		time: '10:45',
		message: 'Texto del usuario de lo que quiera escribir',
	},
];

const ChannelPage = () => {
	const [messages, setMessages] = useState(message);

	const handleSendMessage = (newMessage) => {
		setMessages((prevMessages) => [...prevMessages, newMessage]);
	};

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
				{messages.map((msg, index) => (
					<div key={index}>
						<ChannelMessage msg={msg} />
						{index === 1 && <ChannelMessagesDivider date="11/12/23" />}
						{index === 2 && <ChannelMessagesDivider date="Hoy" />}
					</div>
				))}
			</div>
			<div className={styles.write_message}>
				<ChannelWriteMessage handleSendMessage={handleSendMessage} />
			</div>
		</div>
	);
};

export default ChannelPage;
