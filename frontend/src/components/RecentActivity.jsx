//import React from 'react'

import '@/styles/activity.module.css';
import styles from '@/styles/activity.module.css';

export const RecentActivity = () => {
	return (
		<div className={styles.containerall}>
			<div className={styles.marcoactivity}>
				<div className="nombre-proyecto">
					<h4 className={styles.letra}>Actividad reciente</h4>
				</div>
			</div>

			<div className={styles.containercards}>
				<div>
					<div className="nombre-proyecto">
						<img
							className="piccon"
							src="/images/Card-Recientes.png "
							alt="Texto alternativo de la imagen"
						/>
					</div>
				</div>
				<div>
					<div className="nombre-proyecto">
						<img
							className="piccon"
							src="/images/Card-Recientes2.png"
							alt="Texto alternativo de la imagen"
						/>
					</div>
				</div>
				<div>
					<div className="nombre-proyecto">
						<img
							className="piccon"
							src="/images/Card-Recientes3.png"
							alt="Texto alternativo de la imagen"
						/>{' '}
					</div>
				</div>
				<div>
					<div className="nombre-proyecto">
						<img
							className="piccon"
							src="/images/Card-Recientes4.png"
							alt="Texto alternativo de la imagen"
						/>
					</div>
				</div>
			</div>
		</div>
	);
};
