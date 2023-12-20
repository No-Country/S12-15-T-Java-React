import styles from '@/styles/channelGiphyPicker.module.css';
import { useEffect, useState, useRef } from 'react';

// eslint-disable-next-line no-undef
const apiKey = process.env.NEXT_PUBLIC_GIPHY_API_KEY;

const ChannelGiphyPicker = ({ onGifClick, setIsGiphyPickerVisible }) => {
	const pickerRef = useRef(null);

	const [query, setQuery] = useState('');
	const [gifs, setGifs] = useState([]);

	useEffect(() => {
		const fetchGifs = async () => {
			try {
				const response = await fetch(
					`https://api.giphy.com/v1/gifs/search?q=${query}&api_key=${apiKey}&limit=36`
				);
				const data = await response.json();
				const fetchedGifs = data.data.map((gif) => gif.images.fixed_height.url);
				setGifs(fetchedGifs);
			} catch (error) {
				console.error('Error fetching gifs:', error);
			}
		};

		if (query.length >= 3) {
			fetchGifs();
		} else {
			setGifs([]);
		}
	}, [query]);

	useEffect(() => {
		const handleClickOutside = (event) => {
			if (pickerRef.current && !pickerRef.current.contains(event.target)) {
				setIsGiphyPickerVisible(false);
			}
		};

		document.addEventListener('click', handleClickOutside);
		return () => {
			document.removeEventListener('click', handleClickOutside);
		};
		// eslint-disable-next-line react-hooks/exhaustive-deps
	}, []);
	return (
		<div className={styles.container} ref={pickerRef}>
			<input
				type="text"
				placeholder="Buscar gif..."
				value={query}
				onChange={(e) => setQuery(e.target.value)}
			/>
			<div className={styles.giphy_grid}>
				{gifs.map((gif, index) => (
					<div key={index}>
						<img
							src={gif}
							alt={`GIF ${index + 1}`}
							className={styles.gif_image}
							onClick={() => {
								onGifClick(gif);
								setIsGiphyPickerVisible(false);
							}}
						/>
					</div>
				))}
			</div>
		</div>
	);
};

export default ChannelGiphyPicker;
