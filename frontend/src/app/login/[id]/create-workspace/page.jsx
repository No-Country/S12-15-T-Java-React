'use client';
import { useEffect, useState } from 'react';
import { useRouter } from 'next/navigation';
import FormInputGroup from '@/components/create/FormInputGroup';
import { createWorkspace } from '@/app/api/createWorkspace/createWorkspaceApi';
import FormGuests from '@/components/create/FormGuests';
import Button from '@/components/Button';
import styles from '@/styles/createworkspace.module.css';

const CreateWorkSpace = () => {
	const [proyectName, setProyectName] = useState('');
	const [description, setDescription] = useState('');
	const [loading, setLoading] = useState(false);

	const [userId, setUserId] = useState(null);
	const [token, setToken] = useState(null);

	const router = useRouter();

	useEffect(() => {
		const user = JSON.parse(localStorage.getItem('user'));
		const userToken = localStorage.getItem('token');

		if (user && userToken) {
			setUserId(user.id);
			setToken(userToken);
		}
	}, []);

	const handleSubmit = async (e) => {
		e.preventDefault();

		try {
			setLoading(true);

			const { success, /*idSpace,*/ error } = await createWorkspace(
				userId,
				token,
				proyectName,
				description
			);

			if (success) {
				// router.push(`/login/${userId}/home/${idSpace}/board`);
				router.push(`/login/${userId}/home`); //Temporary redirect to home until workspace with no board/channel id works
				console.log('Workspace creado con éxito');
			} else {
				console.error(error);
			}
		} catch (error) {
			console.error(error.message);
		} finally {
			setLoading(false);
		}
	};
	return (
		<div className={`container ${styles.container_content}`}>
			<form className={styles.container_form} onSubmit={handleSubmit}>
				<FormInputGroup
					proyectName={proyectName}
					setProyectName={setProyectName}
					description={description}
					setDescription={setDescription}
				/>
				<Button className={styles.btn_create} type="submit" disabled={loading}>
					{loading ? 'Cargando...' : 'Crear Proyecto'}
				</Button>
			</form>
		</div>
	);
};

export default CreateWorkSpace;
