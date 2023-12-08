import FormInputGroup from '@/components/create/FormInputGroup';
import FormGuests from '@/components/create/FormGuests';
import Button from '@/components/Button';
import styles from '@/styles/createworkspace.module.css';

const CreateWorkSpace = () => {
	return (
		<div className={`container ${styles.container_content}`}>
			<form className={styles.container_form}>
				<FormInputGroup />
				<FormGuests />
				<Button type="submit" className={styles.btn_create}>
					Crear Proyecto
				</Button>
			</form>
		</div>
	);
};

export default CreateWorkSpace;
