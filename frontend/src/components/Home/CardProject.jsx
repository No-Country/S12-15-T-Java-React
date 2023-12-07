import Image from 'next/image';
import { MemberProject } from './MemberProject';

// import styleCard from '@/styles/home/projects.module.css';
import styleCard from '@/styles/home/cardProjects.module.css';
import { CiUser } from 'react-icons/ci';

export const CardProject = ({
	img,
	nameProject,
	dataMembers,
	nameProjectOwner,
}) => {
	const numberMember = dataMembers ? dataMembers.length : 1;
	const dataMember = dataMembers ? dataMembers.slice(0, 5) : [];
	const projectOwner = nameProjectOwner ? nameProjectOwner : false;

	return (
		<main className={styleCard.card}>
			<Image
				className={styleCard.cardImage}
				src={img}
				width={150}
				height={120}
				alt="ImageProject"
			/>
			<div className={ styleCard.cardNameProject }>
				<span className={styleCard.cardName}> {nameProject} </span>
				{projectOwner && (
					<div className={styleCard.projectOwner}>
						<CiUser className={styleCard.iconUser} />
						<span className={styleCard.nameProjectOwner}>
							{projectOwner}
						</span>
					</div>
				)}
			</div>
			<div className={styleCard.members}>
				<div className={styleCard.memberMap}>
					{dataMember.map((member) => (
						<MemberProject key={member.id} img={member.imgProject} />
					))}
				</div>
				<span className={styleCard.numberMember}>
					{numberMember} miembros
				</span>
			</div>
			<button className={styleCard.buttonGetInto}> Ingresar </button>
		</main>
	);
};
