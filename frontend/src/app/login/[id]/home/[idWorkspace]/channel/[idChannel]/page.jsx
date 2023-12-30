'use client';
import { useEffect, useState, useRef } from 'react';
import ChannelMessage from '@/components/channel/ChannelMessage';
//import ChannelMessagesDivider from '@/components/channel/ChannelMessagesDivider';
import ChannelWriteMessage from '@/components/channel/ChannelWriteMessage';
import styles from '@/styles/channel.module.css';
import {
	getMessages,
	sendMessage,
} from '@/app/api/workspace/channel/channelApi';
import { getChannelData } from '@/app/api/workspace/workspaceApi';
import withAuth from '@/lib/withAuth';

const ChannelPage = ({ params }) => {
	const [messages, setMessages] = useState([]);
	let user;
	if (typeof window !== 'undefined')
		user = JSON.parse(localStorage.getItem('user'));
	const { idChannel } = params;
	const messagesEndRef = useRef(null);
	const [channelName, setChannelName] = useState('');

	const scrollToBottom = () => {
		messagesEndRef.current?.scrollIntoView({ behavior: 'auto' });
	};

	const handleSendMessage = async (newMessage) => {
		//temporary until realtime chat / websocket / receive new message data.
		setMessages((prevMessages) => [
			...(prevMessages || []),
			{
				comments: newMessage,
				userName: user.email,
				localDateTime: new Date().toISOString(),
			},
		]);
		//Send the real message
		await sendMessage(idChannel, newMessage);

		// Scroll to the bottom after sending it
	};

	useEffect(() => {
		const fetchData = async () => {
			try {
				const response = await getMessages(idChannel);
				setMessages(response.data);
			} catch (error) {
				console.error('Error fetching messages:', error);
			}
		};

		const fetchChannelData = async () => {
			try {
				const response = await getChannelData(idChannel);
				const { nameChannel } = response.data;
				setChannelName(nameChannel);
			} catch (error) {
				console.error('Error fetching workspace info:', error);
			}
		};
		fetchChannelData();
		fetchData();
	}, [idChannel]);

	// Auto-scroll to the last message
	useEffect(() => {
		scrollToBottom();
	}, [messages]);
	return (
		<div className={styles.container}>
			<div className={styles.title}>
				<div>
					<img
						src="/images/chat-icon.png"
						alt="channel icon"
						className="channel_icon"
					/>
					<span>
						{channelName == 'Demo nameChannel' ? 'General' : channelName}
					</span>
				</div>

				<div className={styles.members}>
					14 <img src="/images/rectangle-user-icon.png" alt="members icon" />
				</div>
			</div>
			<hr />
			<div className={styles.messages}>
				{Array.isArray(messages) &&
					messages.map((msg) => (
						<div key={msg.localDateTime}>
							<ChannelMessage msg={msg} />
							{/* {index === 1 && <ChannelMessagesDivider date="11/12/23" />}
							{index === 2 && <ChannelMessagesDivider date="Hoy" />} */}
						</div>
					))}
				<div ref={messagesEndRef} />
			</div>
			<div className={styles.write_message}>
				<ChannelWriteMessage handleSendMessage={handleSendMessage} />
			</div>
		</div>
	);
};

const ProtectChannelAuth = withAuth(ChannelPage);

export default ProtectChannelAuth;
