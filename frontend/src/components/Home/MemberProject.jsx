import Image from 'next/image';

import styleMember from '@/styles/home/projects.module.css';

export const MemberProject = ({ img }) => {
	return (
		<div className={styleMember.memberCirculeImage}>
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
