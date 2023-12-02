import styleCard from '@/styles/home/projects.module.css';
import Image from 'next/image';
import { MemberProject } from './MemberProject';

export const CardProject = ({ img, nameProject = 'algo', dataMembers}) => {
	const numberMember = dataMembers ? dataMembers.length : 1;
	const dataMember = dataMembers ? dataMembers.slice(0, 5) : [];

	return (
		<main className={styleCard.card}>
			<Image
				className={styleCard.cardImage}
				src={img}
				width={150}
				height={120}
				alt="ImageProject"
			/>
			<div className={styleCard.cardContent}>
				<main className={styleCard.memberContent}>
					<span className={ styleCard.cardName }> {nameProject} </span>
					<div className={styleCard.members}>
						<div className={ styleCard.memberMap }>
							{
								dataMember.map((member) =>(
									<MemberProject key={ member.id } img={ member.imgProject } /> 
								))
							}
						</div>
						<span className={ styleCard.numberMember }> { numberMember } miembros </span>
					</div>
				</main>

				<button className={styleCard.buttonGetInto}> Ingresar </button>
			</div>
		</main>
	);
};
