'use client';
import { useState } from 'react';

import styleProject from '@/styles/home/projects.module.css';
import { IoIosArrowDown } from 'react-icons/io';

export const ShapeProjects = ({
	name,
	children,
	styles,
	styleHeader,
	lengthData,
	btnCreate,
}) => {
	const buttonSeemore = lengthData > 2 ? true : false;
	const [heightContent, setHeightContent] = useState('19.5rem');
	const [overflowContent, setOverflowContent] = useState('hidden');

	const handleSeeMore = () => {
		if (heightContent === 'none' && overflowContent === 'none') {
			// Contract Content
			setHeightContent('19.5rem');
			setOverflowContent('hidden');
		} else {
			// Expand Content
			setHeightContent('none');
			setOverflowContent('none');
		}
	};

	return (
		<main className={styles}>
			<header className={styleHeader}>
				{name}
				{btnCreate && (
					<button className={styleProject.buttonCreate}> Crear </button>
				)}
			</header>
			<div
				style={{
					maxHeight: heightContent,
					overflow: overflowContent,
					transition: 'max-height 0.5s ease-out',
				}}
			>
				{' '}
				{children}{' '}
			</div>
			{buttonSeemore && (
				<button className={styleProject.footer} onClick={handleSeeMore}>
					Ver más <IoIosArrowDown className={styleProject.iconArrow} />
				</button>
			)}
		</main>
	);
};
