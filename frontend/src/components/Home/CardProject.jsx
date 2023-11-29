import styleCard from '@/styles/home/projects.module.css';
import Image from 'next/image';
import { MemberProject } from './MemberProject';

export const CardProject = ({ img, nameProject = 'algo', members = 10 }) => {
	return (
		<main className={styleCard.card}>
			<Image
				className={styleCard.cardImage}
				src={img}
				width={120}
				height={120}
				alt="ImageProject"
			/>
			<div className={styleCard.cardContent}>
				<main className={styleCard.memberContent}>
					<span> {nameProject} </span>
					<div className={styleCard.members}>
						<MemberProject img={img} />
						<span> {members} miembros </span>
					</div>
				</main>

				<button className={styleCard.buttonGetInto}> Ingresar </button>
			</div>
		</main>
	);
};
