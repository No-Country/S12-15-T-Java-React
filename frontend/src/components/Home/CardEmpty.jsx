import styleCard from '@/styles/home/cardProjects.module.css';

export const CardEmpty = ({ notice }) => {
	return <main className={styleCard.cardEmpty}>{notice}</main>;
};
