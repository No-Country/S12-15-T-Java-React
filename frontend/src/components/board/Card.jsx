import styleCard from '@/styles/board/addCard.module.css';
import { useSortable } from '@dnd-kit/sortable';
import { CSS } from '@dnd-kit/utilities';

export const Card = ({ card, onClick }) => {
	const { attributes, listeners, setNodeRef, transform, transition } =
		useSortable({
			id: card.id,
		});

	const style = {
		transform: CSS.Transform.toString(transform),
		transition,
	};

	return (
		<div
			ref={setNodeRef}
			{...attributes}
			{...listeners}
			style={style}
			className={styleCard.card}
			onClick={onClick}
		>
			<span className={styleCard.cardName}>{card.name}</span>
		</div>
	);
};
