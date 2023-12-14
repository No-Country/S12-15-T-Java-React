'use client';
import { useState } from 'react';
import styles from '@/styles/channelWriteMessage.module.css';
import ChannelEmojiPicker from './ChannelEmojiPicker';

const ChannelWriteMessage = ({ handleSendMessage }) => {
	const [newMessage, setNewMessage] = useState('');
	const [isEmojiPickerVisible, setIsEmojiPickerVisible] = useState(false);

	const toggleEmojiPickerVisibility = () => {
		setIsEmojiPickerVisible(!isEmojiPickerVisible);
	};

	const handleEmojiClick = (emoji) => {
		setNewMessage((prevMessage) => prevMessage + emoji);
	};

	const handleSubmit = (e) => {
		e.preventDefault();

		if (newMessage.trim() === '') {
			return;
		}

		// Add zero if hour is 1 digit
		const addZero = (value) => (value < 10 ? `0${value}` : value);

		const currentDate = new Date();

		const formattedDate = `${currentDate.getDate()}/${
			currentDate.getMonth() + 1
		}/${currentDate.getFullYear()}`;

		const formattedTime = `${addZero(currentDate.getHours())}:${addZero(
			currentDate.getMinutes()
		)}`;

		const messageObject = {
			id: Math.random(),
			username: 'Nombre del usuario',
			date: formattedDate,
			time: formattedTime,
			message: newMessage,
		};

		//Send Message
		handleSendMessage(messageObject);

		//Clear input
		setNewMessage('');
	};
	return (
		<form className={styles.form} onSubmit={handleSubmit}>
			<input
				type="text"
				className={styles.write_message_input}
				placeholder="Escribe un mensaje"
				value={newMessage}
				onChange={(e) => setNewMessage(e.target.value)}
			/>
			<div className={styles.menu}>
				<div>
					<svg
						xmlns="http://www.w3.org/2000/svg"
						width="20"
						height="20"
						viewBox="0 0 20 20"
						fill="none"
					>
						<path
							d="M4.82841 10.4852L10.4853 4.82839C11.6568 3.65681 13.5563 3.65681 14.7279 4.82839C15.8995 5.99996 15.8995 7.89945 14.7279 9.07103L8.01039 15.7885C7.4246 16.3743 6.47485 16.3743 5.88907 15.7885C5.30328 15.2028 5.30328 14.253 5.88907 13.6672L11.8995 7.65681C12.0947 7.46155 12.0947 7.14497 11.8995 6.94971C11.7042 6.75444 11.3876 6.75444 11.1924 6.94971L5.18196 12.9601C4.20565 13.9364 4.20565 15.5193 5.18196 16.4956C6.15827 17.472 7.74118 17.472 8.71749 16.4956L15.435 9.77813C16.9971 8.21604 16.9971 5.68338 15.435 4.12128C13.8729 2.55918 11.3403 2.55918 9.77815 4.12128L4.1213 9.77813C3.92604 9.9734 3.92604 10.29 4.1213 10.4852C4.31656 10.6805 4.63315 10.6805 4.82841 10.4852Z"
							fill="#1E1E1E"
						/>
					</svg>
					<svg
						xmlns="http://www.w3.org/2000/svg"
						width="20"
						height="20"
						viewBox="0 0 20 20"
						fill="none"
						onClick={toggleEmojiPickerVisibility}
					>
						<path
							d="M10 2C14.4183 2 18 5.58172 18 10C18 14.4183 14.4183 18 10 18C5.58172 18 2 14.4183 2 10C2 5.58172 5.58172 2 10 2ZM10 3C6.13401 3 3 6.13401 3 10C3 13.866 6.13401 17 10 17C13.866 17 17 13.866 17 10C17 6.13401 13.866 3 10 3ZM7.15467 12.4273C8.66416 13.9463 11.0877 14.0045 12.6671 12.5961L12.8453 12.4273C13.04 12.2314 13.3566 12.2304 13.5524 12.4251C13.7265 12.5981 13.7467 12.8674 13.6123 13.0627L13.5547 13.1322L13.5323 13.1545C11.5691 15.1054 8.39616 15.0953 6.44533 13.1322C6.25069 12.9363 6.25169 12.6197 6.44757 12.4251C6.64344 12.2304 6.96002 12.2314 7.15467 12.4273ZM12.5 7.5C13.0523 7.5 13.5 7.94772 13.5 8.5C13.5 9.05228 13.0523 9.5 12.5 9.5C11.9477 9.5 11.5 9.05228 11.5 8.5C11.5 7.94772 11.9477 7.5 12.5 7.5ZM7.5 7.5C8.05228 7.5 8.5 7.94772 8.5 8.5C8.5 9.05228 8.05228 9.5 7.5 9.5C6.94772 9.5 6.5 9.05228 6.5 8.5C6.5 7.94772 6.94772 7.5 7.5 7.5Z"
							fill="#1E1E1E"
						/>
					</svg>

					<svg
						xmlns="http://www.w3.org/2000/svg"
						width="20"
						height="20"
						viewBox="0 0 20 20"
						fill="none"
					>
						<path
							d="M15.4 3C16.7864 3 17.9194 4.1869 17.9959 5.68238L18 5.84375V14.1562C18 15.6727 16.9148 16.9118 15.5475 16.9955L15.4 17H4.6C3.21357 17 2.0806 15.8131 2.00412 14.3176L2 14.1562V5.84375C2 4.32735 3.08516 3.08816 4.45246 3.0045L4.6 3H15.4ZM15.25 4H4.75C3.82377 4 3.06561 4.793 3.00404 5.79653L3 5.92857V14.0714C3 15.0922 3.71957 15.9277 4.63018 15.9956L4.75 16H15.25C16.1762 16 16.9344 15.207 16.996 14.2035L17 14.0714V5.92857C17 4.90783 16.2804 4.0723 15.3698 4.00445L15.25 4ZM6.85135 7.00214C7.4713 7.00214 7.99907 7.0988 8.43229 7.30058C8.69893 7.42477 8.80624 7.72539 8.67198 7.97203C8.53772 8.21867 8.21272 8.31793 7.94609 8.19374C7.6779 8.06883 7.31378 8.00214 6.85135 8.00214C5.82473 8.00214 5.08108 8.8345 5.08108 10.0011C5.08108 11.1209 5.89403 12 6.85135 12C7.44761 12 7.85273 11.6487 7.91152 11.3268L7.91892 11.2472V10.5011L7.54054 10.5C7.24201 10.5 7 10.2761 7 10C7 9.75454 7.19122 9.55039 7.44338 9.50806L7.54054 9.5L8.45946 9.50107C8.72482 9.50107 8.94552 9.67794 8.99129 9.91119L9 10.0011V11.2472C9 12.1244 8.11351 13 6.85135 13C5.25622 13 4 11.6415 4 10.0011C4 8.31985 5.17727 7.00214 6.85135 7.00214ZM11 7C11.2455 7 11.4496 7.17688 11.4919 7.41012L11.5 7.5V12.5C11.5 12.7761 11.2761 13 11 13C10.7545 13 10.5504 12.8231 10.5081 12.5899L10.5 12.5V7.5C10.5 7.22386 10.7239 7 11 7ZM15.5 7C15.7761 7 16 7.22386 16 7.5C16 7.74546 15.8231 7.94961 15.5899 7.99194L15.5 8H14V10H15.5C15.7761 10 16 10.2239 16 10.5C16 10.7455 15.8231 10.9496 15.5899 10.9919L15.5 11H14V12.5C14 12.7761 13.7761 13 13.5 13C13.2545 13 13.0504 12.8231 13.0081 12.5899L13 12.5V7.5C13 7.22386 13.2239 7 13.5 7H15.5Z"
							fill="#1E1E1E"
						/>
					</svg>
				</div>
				{isEmojiPickerVisible && (
					<div className={styles.pickerContainer}>
						<ChannelEmojiPicker
							onEmojiClick={handleEmojiClick}
							setIsEmojiPickerVisible={setIsEmojiPickerVisible}
						/>
					</div>
				)}
				<button type="submit">
					<svg
						xmlns="http://www.w3.org/2000/svg"
						width="20"
						height="20"
						viewBox="0 0 20 20"
						fill="none"
					>
						<path
							d="M2.72113 2.05149L18.0756 9.61746C18.3233 9.73952 18.4252 10.0393 18.3031 10.287C18.2544 10.3858 18.1744 10.4658 18.0756 10.5145L2.72144 18.0803C2.47374 18.2023 2.17399 18.1005 2.05193 17.8528C1.99856 17.7445 1.98619 17.6205 2.0171 17.5038L3.9858 10.0701L2.01676 2.62789C1.94612 2.36093 2.10528 2.08726 2.37224 2.01663C2.48893 1.98576 2.61285 1.99814 2.72113 2.05149ZM3.26445 3.43403L4.87357 9.51612L4.93555 9.50412L5 9.5H12C12.2761 9.5 12.5 9.72386 12.5 10C12.5 10.2455 12.3231 10.4496 12.0899 10.4919L12 10.5H5C4.9686 10.5 4.93787 10.4971 4.90807 10.4916L3.26508 16.6976L16.7234 10.066L3.26445 3.43403Z"
							fill="#1E1E1E"
						/>
					</svg>
				</button>
			</div>
		</form>
	);
};

export default ChannelWriteMessage;
