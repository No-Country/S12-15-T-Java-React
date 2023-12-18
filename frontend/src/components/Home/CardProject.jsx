import Image from 'next/image';
// import { MemberProject } from './MemberProject';

// import styleCard from '@/styles/home/projects.module.css';
import styleCard from '@/styles/home/cardProjects.module.css';
import { CiUser } from 'react-icons/ci';
import Link from 'next/link';

export const CardProject = ({
	img,
	nameProject,
	idSpace,
	idUser,
	// dataMembers,
	nameProjectOwner,
}) => {
	const imgUrl = img !== null ? img : '/images/projects.jpg';
	const projectOwner = nameProjectOwner ? nameProjectOwner : false;
	// const numberMember = dataMembers ? dataMembers.length : 1;
	// const dataMember = dataMembers ? dataMembers.slice(0, 5) : [];

	return (
		<main className={styleCard.card}>
			<Image
				className={styleCard.cardImage}
				src={imgUrl}
				width={150}
				height={120}
				alt="ImageProject"
			/>
			<div className={styleCard.cardNameProject}>
				<span className={styleCard.cardName}> {nameProject} </span>
				{projectOwner && (
					<div className={styleCard.projectOwner}>
						<CiUser className={styleCard.iconUser} />
						<span className={styleCard.nameProjectOwner}>{projectOwner}</span>
					</div>
				)}
			</div>
			{/* <div className={styleCard.members}>
				<div className={styleCard.memberMap}>
					{dataMember.map((member) => (
						<MemberProject key={member.id} img={member.imgProject} />
					))}
				</div>
				<span className={styleCard.numberMember}>{numberMember} miembros</span>
			</div> */}
			<Link 
				href={`/login/${idUser}/home/${idSpace}/board`}
				className={styleCard.buttonGetInto}
			>
				Ingresar
				{/* <button className={styleCard.buttonGetInto}> Ingresar </button>  */}
			</Link> 
		</main>
	);
};
