import styleCard from '@/styles/home/projects.module.css';

export const CardEmpty = ({ notice }) => {
	return <main className={styleCard.cardEmpty}>{notice}</main>;
};
