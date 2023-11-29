import Image from 'next/image';
import styleMember from '@/styles/home/projects.module.css';

export const MemberProject = ({ img }) => {
	return (
		<div className={styleMember.overlap}>
			<Image
				className={styleMember.memberImage}
				src={img}
				width={32}
				height={32}
				alt="ImageMember"
			/>
			<Image
				className={styleMember.memberImage}
				src={img}
				width={32}
				height={32}
				alt="ImageMember"
			/>
		</div>
	);
};
