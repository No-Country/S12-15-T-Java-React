import FormInputGroup from '@/components/create/FormInputGroup';
import FormGuests from '@/components/create/FormGuests';
import styles from '@/styles/createworkspace.module.css';
import Link from 'next/link';

const CreateWorkSpace = () => {
	return (
		<div className={`container ${styles.container_content}`}>
			<form className={styles.container_form}>
				<FormInputGroup />
				<FormGuests />
				<Link href="/login/1/home/1/board" className={styles.btn_create}>
					Crear Proyecto
				</Link>
			</form>
		</div>
	);
};

export default CreateWorkSpace;
