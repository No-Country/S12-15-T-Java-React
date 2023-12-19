'use client';
import { FaTrashAlt } from 'react-icons/fa';
import { MdOutlineTableRows } from 'react-icons/md';
import styleBoard from '@/styles/board/board.module.css';
import Image from 'next/image';
import ListBoard from '@/components/board/ListBoard';
import { AddList } from '@/components/board/AddList';

const Boardpage = () => {
	return (
		<div className={styleBoard.board}>
			<header className={styleBoard.header}>
				<div className={styleBoard.headerName}>
					<MdOutlineTableRows className={styleBoard.iconBoard} />
					<span className={styleBoard.nameBoard}>Nombre tablero</span>
				</div>
				<div className={styleBoard.headerUsers}>
					<span className={styleBoard.numberUser}>124</span>
					<Image
						src="/images/rectangle-user-icon.png"
						width={35}
						height={35}
						alt="iconBoard"
					/>
					<button className={styleBoard.btnTrash}>
						<FaTrashAlt className={styleBoard.trash} />
					</button>
				</div>
			</header>
			<main className={styleBoard.tableBoard}>
				<div>
					<ListBoard name={'Title list'} />
				</div>
				<AddList />
			</main>
		</div>
	);
};

export default Boardpage;
