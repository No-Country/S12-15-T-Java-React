import styles from '@/styles/channelEmojiPicker.module.css';
import { useEffect, useRef } from 'react';
const emojis = [
	'😃',
	'😄',
	'😁',
	'😆',
	'😅',
	'😂',
	'🤣',
	'😊',
	'😇',
	'🙂',
	'🙃',
	'😉',
	'😌',
	'😍',
	'😎',
	'😏',
	'😐',
	'😑',
	'😒',
	'😓',
	'😔',
	'😕',
	'🙁',
	'☹️',
	'😖',
	'😞',
	'😟',
	'😠',
	'😡',
	'😢',
	'😣',
	'😤',
	'😥',
	'😦',
	'😧',
	'😨',
	'😩',
	'😪',
	'😫',
	'😬',
	'😭',
	'😮',
	'😯',
	'😰',
	'😱',
	'😳',
	'😵',
	'😲',
	'😷',
	'🤐',
	'🤢',
	'🤕',
	'🙄',
	'😶',
	'🤔',
	'🤒',
	'👍',
	'👎',
	'👏',
	'🙌',
	'🤝',
	'🚀',
	'✅',
	'❌',
	'📅',
	'📌',
	'📎',
	'💡',
	'🔍',
	'🔒',
	'🔓',
	'🔔',
	'🎉',
	'🎈',
	'🎊',
	'🍕',
	'🍔',
	'🍟',
	'🍦',
	'🍻',
	'🍷',
	'🍸',
	'🎸',
	'🎮',
	'🎲',
	'🏆',
	'📚',
	'💻',
	'📱',
	'💼',
	'🎤',
	'🎧',
	'🎨',
	'🎭',
	'🚗',
	'🚀',
	'✈️',
	'🚢',
	'🚁',
	'🏰',
	'🌟',
	'🌈',
	'🍀',
	'🌺',
	'🎃',
	'🎅',
	'🎁',
	'🎄',
];

const ChannelEmojiPicker = ({ onEmojiClick, setIsEmojiPickerVisible }) => {
	const pickerRef = useRef(null);
	useEffect(() => {
		const handleClickOutside = (event) => {
			if (pickerRef.current && !pickerRef.current.contains(event.target)) {
				setIsEmojiPickerVisible(false);
			}
		};

		document.addEventListener('click', handleClickOutside);
		return () => {
			document.removeEventListener('click', handleClickOutside);
		};
	}, []);
	return (
		<div className={styles.container} ref={pickerRef}>
			{emojis.map((emoji, index) => (
				<span key={index} onClick={() => onEmojiClick(emoji)}>
					{emoji}
				</span>
			))}
		</div>
	);
};

export default ChannelEmojiPicker;
