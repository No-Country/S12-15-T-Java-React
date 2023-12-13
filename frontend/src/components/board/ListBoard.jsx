import AddCard from './AddCard';
import { BsThreeDots } from 'react-icons/bs';
import styleList from '@/styles/board/listBoard.module.css';

const ListBoard = () => {
	return (
		<main className={styleList.listBoard}>
			<header className={styleList.headerList}>
				<span className={styleList.listName}>Title list</span>
				<button className={styleList.points}>
					<BsThreeDots className={styleList.threePoints} />
				</button>
			</header>
			<AddCard />
		</main>
	);
};

export default ListBoard;
